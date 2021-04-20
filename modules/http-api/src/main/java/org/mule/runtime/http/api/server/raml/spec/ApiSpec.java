/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.api.server.raml.spec;

/**
 * Represents an api specificiation
 */
public interface ApiSpec {

  /**
   * Adds a an endpoint to the spec.
   * 
   * @param endpoint endpoint to be added
   */
  void addEndpoint(String endpoint);

  /**
   * Retrieves the api spec as a string
   * 
   * @return the string representation of an apiﬂ
   */
  String getSpecAsString();

}
