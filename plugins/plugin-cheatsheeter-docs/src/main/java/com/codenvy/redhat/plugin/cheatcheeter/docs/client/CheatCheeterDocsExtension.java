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
package com.codenvy.redhat.plugin.cheatcheeter.docs.client;

import com.codenvy.redhat.plugin.cheatcheeter.docs.client.docs.DocsPartPresenter;
import com.google.web.bindery.event.shared.EventBus;

import org.eclipse.che.ide.api.extension.Extension;
import org.eclipse.che.ide.api.machine.events.WsAgentStateEvent;
import org.eclipse.che.ide.api.machine.events.WsAgentStateHandler;
import org.eclipse.che.ide.api.parts.PartStackType;
import org.eclipse.che.ide.api.parts.WorkspaceAgent;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author Alexander Andrienko
 */
@Singleton
@Extension(title = "CheatCheeter docs extension.",
           description = "Extension to display static html content parsed from '.cheatsheet.xml'",
           version = "1.0.0")
public class CheatCheeterDocsExtension {

    @Inject
    public CheatCheeterDocsExtension(EventBus eventBus,
                                     final DocsPartPresenter docsPartPresenter,
                                     final WorkspaceAgent workspaceAgent) {
        eventBus.addHandler(WsAgentStateEvent.TYPE, new WsAgentStateHandler() {
            @Override
            public void onWsAgentStarted(WsAgentStateEvent wsAgentStateEvent) {
                docsPartPresenter.init();
                if (docsPartPresenter.getDocsUrl() != null) {
                    workspaceAgent.openPart(docsPartPresenter, PartStackType.TOOLING);
                }
            }

            @Override
            public void onWsAgentStopped(WsAgentStateEvent wsAgentStateEvent) {
                workspaceAgent.removePart(docsPartPresenter);
            }
        });
    }
}
