/*
 * Copyright 2022 Block Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("UsePropertyAccessSyntax")

package com.squareup.wire.recipes

import com.squareup.wire.WireTestLogger
import com.squareup.wire.buildSchema
import com.squareup.wire.schema.SchemaHandler
import okio.Path.Companion.toPath
import okio.fakefilesystem.FakeFileSystem
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LogToWireLoggerHandlerTest {
  @Test fun loggingArtifacts() {
    val schema = buildSchema {
      add(
        name = "test/message.proto".toPath(),
        protoFile = """
            |syntax = "proto2";
            |
            |package test;
            |
            |message Request {}
            |message Response {
            |  optional string result = 1;
            |}
          """.trimMargin()
      )
      add(
        name = "test/service.proto".toPath(),
        protoFile = """
            |syntax = "proto2";
            |
            |package test;
            |
            |import "test/message.proto";
            |
            |service MyService {
            |  rpc fetch(test.Request) returns(test.Response) {};
            |}
          """.trimMargin()
      )
    }
    val logger = WireTestLogger()
    val context = SchemaHandler.Context(
      fileSystem = FakeFileSystem(),
      outDirectory = "out".toPath(),
      logger = logger,
      sourcePathPaths = setOf("test/message.proto", "test/service.proto"),
    )
    LogToWireLoggerHandler().handle(schema, context)

    assertEquals(Triple("out".toPath(), "test", "Request"), logger.artifactHandled.removeFirst())
    assertEquals(Triple("out".toPath(), "test", "Response"), logger.artifactHandled.removeFirst())
    assertEquals(Triple("out".toPath(), "test", "MyService"), logger.artifactHandled.removeFirst())
    assertTrue(logger.artifactHandled.isEmpty())
  }
}