/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.test.values.extension.source;

import static org.mule.runtime.extension.api.annotation.param.MediaType.TEXT_PLAIN;

import org.mule.runtime.core.api.util.Base64.InputStream;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.sdk.api.values.FieldValues;
import org.mule.test.values.extension.resolver.SdkMultiLevelValueProvider;
import org.mule.test.values.extension.resolver.SimpleValueProvider;

@MediaType(TEXT_PLAIN)
public class SourceWithMultiLevelFieldValues extends AbstractSdkSource {

  @FieldValues(targetPaths = "channel", value = SimpleValueProvider.class)
  @FieldValues(targetPaths = {"location.continent", "location.country", "location.city"},
      value = SdkMultiLevelValueProvider.class)
  @Parameter
  InputStream body;
}
