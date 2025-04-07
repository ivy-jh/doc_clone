Custom editor
~~~~~~~~~~~~~~~~~~~~

To define your custom configuration on the process inscription mask, you must supply
an inner ``Editor`` class implementation. We recommend to extend your implementation
from :public-api:`UiEditorExtension </ch/ivyteam/ivy/process/extension/ui/UiEditorExtension.html>`.

This editor class is responsible for two things: 
Firstly, to create UI widgets, which display configuration values. 
And secondly, to map configuration data onto these widgets:

  1. The :public-api:`initUiFields </ch/ivyteam/ivy/process/extension/ui/UiEditorExtension.html>` method
  supports you in creating widgets for the editor. Currently labels, scriptEditors and textEditors are supported.

  2. The  :public-api:`ConfigurableExtensionEditor </ch/ivyteam/ivy/process/extension/impl/ConfigurableExtensionEditor.html>`
  provides methods to read and write configurations, in order to bind them to previously created ui widgets.
