/*******************************************************************************
 * Copyright (c) 2012-2017 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package com.codenvy.redhat.plugin.product.info.client;

import com.google.inject.Singleton;

import org.eclipse.che.ide.api.ProductInfoDataProvider;
import org.vectomatic.dom.svg.ui.SVGResource;

import javax.inject.Inject;


/**
 * Implementation of {@link ProductInfoDataProvider}
 *
 * @author Alexander Andrienko
 * @author Oleksii Orel
 */
@Singleton
public class CodenvyProductInfoDataProvider implements ProductInfoDataProvider {
    private final CodenvyLocalizationConstant locale;
    private final CodenvyResources            resources;

    @Inject
    public CodenvyProductInfoDataProvider(CodenvyLocalizationConstant locale, CodenvyResources resources) {
        this.locale = locale;
        this.resources = resources;
    }

    @Override
    public String getName() {
        return locale.getProductName();
    }

    @Override
    public String getSupportLink() {
        return locale.getSupportLink();
    }

    @Override
    public String getDocumentTitle() {
        return locale.codenvyTabTitle();
    }

    @Override
    public String getDocumentTitle(String workspaceName) {
        return locale.codenvyTabTitle(workspaceName);
    }

    @Override
    public SVGResource getLogo() {
        return resources.logo();
    }

    @Override
    public String getSupportTitle() {
        return locale.supportTitle();
    }
}
