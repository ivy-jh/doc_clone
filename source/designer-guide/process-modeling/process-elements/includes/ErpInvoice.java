package com.axonivy.wf.custom;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.axonivy.wf.custom.ErpPrintJob.Config;

import ch.ivyteam.ivy.process.eventstart.AbstractProcessStartEventBean;
import ch.ivyteam.ivy.process.extension.ui.ExtensionUiBuilder;
import ch.ivyteam.ivy.process.extension.ui.IUiFieldEditor;
import ch.ivyteam.ivy.process.extension.ui.UiEditorExtension;
import ch.ivyteam.ivy.request.RequestException;
import ch.ivyteam.util.PropertiesUtil;

public class ErpInvoice extends AbstractProcessStartEventBean {

  public ErpInvoice() {
    super("ErpInvoice", "Integrates ERP updates driven by CSV files");
  }

  @Override
  public void poll() {
    int seconds = Optional.ofNullable(getConfig().get(Config.INTERVAL))
      .map(Integer::parseInt).orElse(60);
    getEventBeanRuntime().poll().every(Duration.ofSeconds(seconds));

    String path = getConfig().get(Config.PATH);
    try (Stream<Path> csv = Files.list(Path.of(path))) {
      List<Path> updates = csv.collect(Collectors.toList());
      startProcess("new stock items", Map.of("sheets", updates));
    } catch (IOException ex) {
      getEventBeanRuntime().getRuntimeLogLogger().error("Failed to check ERP for updates", ex);
    }
  }

  private void startProcess(String firingReason, Map<String, Object> parameters) {
    try {
      getEventBeanRuntime().processStarter()
        .withReason(firingReason)
        .withParameters(parameters)
        .start();
    } catch (RequestException ex) {
      getEventBeanRuntime().getRuntimeLogLogger().error("Failed to init ERP driven process", ex);
    }
  }

  public static class Editor extends UiEditorExtension {

    @Override
    public void initUiFields(ExtensionUiBuilder ui) {
      ui.label("Path to read .CSV stock-item changes:").create();
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
