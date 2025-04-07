package com.axonivy.wf.custom;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

import ch.ivyteam.ivy.persistence.PersistencyException;
import ch.ivyteam.ivy.process.extension.ui.ExtensionUiBuilder;
import ch.ivyteam.ivy.process.extension.ui.IUiFieldEditor;
import ch.ivyteam.ivy.process.extension.ui.UiEditorExtension;
import ch.ivyteam.ivy.process.intermediateevent.AbstractProcessIntermediateEventBean;
import ch.ivyteam.util.PropertiesUtil;

public class ErpPrintJob extends AbstractProcessIntermediateEventBean {

  public ErpPrintJob() {
    super("ErpPrintJob", "Waits for ERP reports", File.class);
  }

  @Override
  public void poll() {
    int seconds = Optional.ofNullable(getConfig().get(Config.INTERVAL))
      .map(Integer::parseInt).orElse(60);
    getEventBeanRuntime().poll().every(Duration.ofSeconds(seconds));

    String path = getConfig().get(Config.PATH);
    try (Stream<Path> csv = Files.list(Path.of(path)).filter(f -> f.startsWith("erp-print"))) {
      List<Path> reports = csv.collect(Collectors.toList());
      for(Path report : reports) {
        String fileName = report.getFileName().toString();
        String eventId = StringUtils.substringBefore(fileName, ".pdf");
        continueProcess(report.toFile(), eventId);
      }
    } catch (IOException ex) {
      getEventBeanRuntime().getRuntimeLogLogger().error("Failed to check ERP for updates", ex);
    }
  }

  private void continueProcess(File report, String eventId) {
    try {
      getEventBeanRuntime().fireProcessIntermediateEventEx(eventId, report, "");
    } catch (PersistencyException ex) {
      getEventBeanRuntime().getRuntimeLogLogger().error("Failed to resume process with event"+ eventId, ex);
    }
  }

  public static class Editor extends UiEditorExtension {

    @Override
    public void initUiFields(ExtensionUiBuilder ui) {
      ui.label("Path to read produced PDF files from:").create();
      ui.textField(Config.PATH).create();

      ui.label("Interval in seconds to check for changes:").create();
      ui.scriptField(Config.INTERVAL).requireType(Integer.class).create();
    }

  }

  private interface Config {
    String PATH = "path";
    String INTERVAL = "interval";
  }

}
