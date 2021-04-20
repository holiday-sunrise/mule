/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.api.server.raml.spec;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.raml.simpleemitter.Emitter;
import org.raml.v2.api.model.v10.api.Api;

/**
 * A RAML Spec
 */
public class RamlSpec implements ApiSpec {

  public static final String API_RETRIEVAL_PATH = "/apiSpec";

  private Api api;

  public void setApi(Api api) {
    this.api = api;
  }

  public Api getApi() {
    return api;
  }

  @Override
  public String getSpecAsString() {
    try {
      Emitter emitter = new Emitter();
      StringWriter sw = new StringWriter();
      emitter.emit(this.getApi(), sw);
      return sw.toString();
    } catch (IOException e) {
      throw new RuntimeException("Error writing raml");
    }
  }
}
