/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.test.values.extension.config;

import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.sdk.api.values.FieldValues;
import org.mule.test.values.extension.connection.ValuesConnectionProvider;
import org.mule.test.values.extension.resolver.SimpleValueProvider;

@Configuration(name = "config-with-parameter-with-field-values")
@ConnectionProviders(ValuesConnectionProvider.class)
public class ConfigWithParameterWithFieldValues {

  @Parameter
  @FieldValues(targetPaths = "simple.path", value = SimpleValueProvider.class)
  String channel;
}
