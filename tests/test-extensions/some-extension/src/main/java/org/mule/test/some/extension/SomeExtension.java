/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.test.some.extension;

import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Export;
import org.mule.runtime.extension.api.annotation.Extension;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.Sources;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.dsl.xml.Xml;
import org.mule.runtime.extension.api.annotation.error.ErrorTypes;
import org.mule.sdk.api.annotation.param.Optional;
import org.mule.sdk.api.annotation.param.Parameter;
import org.mule.test.heisenberg.extension.HeisenbergErrors;

import java.time.ZonedDateTime;

@Extension(name = "SomeExtension")
@Configuration(name = "config")
@ConnectionProviders(ExtConnProvider.class)
@ErrorTypes(HeisenbergErrors.class)
@Operations({SomeOps.class})
@Export(classes = CustomConnectionException.class)
@Sources({SomeEmittingSource.class, AnotherEmittingSource.class, YetAnotherEmittingSource.class,
    ParameterEmittingSource.class})
@Xml(namespace = "http://www.mulesoft.org/schema/mule/some", prefix = "some")
public class SomeExtension {

  @Parameter
  @Optional
  private ZonedDateTime zonedDateTime;

  public ZonedDateTime getZonedDateTime() {
    return zonedDateTime;
  }
}
