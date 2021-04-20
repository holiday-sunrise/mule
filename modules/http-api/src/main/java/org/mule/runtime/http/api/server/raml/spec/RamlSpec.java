/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.api.server.raml.spec;

import java.util.HashMap;
import java.util.Map;

/**
 * A RAML Spec
 */
public class RamlSpec implements ApiSpec {

  public static final String API_RETRIEVAL_PATH = "/apiSpec";

  private Map<String, String> endpoints = new HashMap<String, String>();

  @Override
  public void addEndpoint(String endpointName) {
    endpoints.put(endpointName, "");

  }

  @Override
  public String getSpecAsString() {
    StringBuffer buffer = new StringBuffer();
    for (String endpoint : endpoints.keySet()) {
      if (endpoint.equals(API_RETRIEVAL_PATH)) {
        continue;
      }
      buffer.append(endpoint);
      buffer.append(" ");
    }
    return buffer.toString();
  }


}
