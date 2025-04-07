package com.axonivy.wf.custom;

import com.axonivy.erp.ErpFileService;

import ch.ivyteam.ivy.process.engine.IRequestId;
import ch.ivyteam.ivy.process.extension.impl.AbstractUserProcessExtension;
import ch.ivyteam.ivy.process.extension.ui.ExtensionUiBuilder;
import ch.ivyteam.ivy.process.extension.ui.IUiFieldEditor;
import ch.ivyteam.ivy.process.extension.ui.UiEditorExtension;
import ch.ivyteam.ivy.scripting.language.IIvyScriptContext;
import ch.ivyteam.ivy.scripting.objects.CompositeObject;
import ch.ivyteam.ivy.scripting.objects.File;

public class ErpLoader extends AbstractUserProcessExtension {

  @Override
  public CompositeObject perform(IRequestId requestId, CompositeObject in, IIvyScriptContext context) throws Exception {
    String pathScript = getConfig().get(Config.PATH);
    File statistics = (File) executeIvyScript(context, pathScript);
    if (statistics.exists()) {
      ErpFileService.instance().reportStats(statistics);
    } else {
      getLog(context).warn("Failed to resolve statistics file from "+pathScript);
    }
    return in;
  }

  public static class Editor extends UiEditorExtension {

    @Override
    public void initUiFields(ExtensionUiBuilder ui) {
      ui.label("The CSV statistic to report to Acme.ERP:").create();
      ui.scriptField(Config.PATH).requireType(File.class).create();
    }

  }

  private static interface Config {
    String PATH = "path";
  }

}
