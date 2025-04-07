Editor Tab
~~~~~~~~~~

This tab displays the editor that can be integrated in the external Java bean of
the process element. The editor is implemented as an inner public static class
of the Java bean class and has to have the name ``Editor``. Additionally, the
editor class has to implement the
:public-api:`IProcessExtensionConfigurationEditorEx
</ch/ivyteam/ivy/process/extension/IProcessExtensionConfigurationEditorEx.html>`
interface. The common way to implement the editor class is to extend the
abstract base class :public-api:`AbstractProcessExtensionConfigurationEditor
</ch/ivyteam/ivy/process/extension/impl/AbstractProcessExtensionConfigurationEditor.html>`
and to override the methods ``createEditorPanelContent``,
``loadUiDataFromConfiguration`` and ``saveUiDataToConfiguration``. The method
``createEditorPanelContent`` can be used to build the UI components of the
editor. You can add any Swing component to the given ``editorPanel``
parameter. With the ``editorEnvironment`` parameter, which is of the type
:public-api:`IProcessExtensionConfigurationEditorEnvironment
</ch/ivyteam/ivy/process/extension/IProcessExtensionConfigurationEditorEnvironment.html>`,
you can create text fields that support IvyScript and have smart buttons that
provide access to the process data, environment functions and Java classes.

Here is an example on how an editor could look like:

.. figure::  /_images/process-elements/program-interface-activy-sample.png

As you can see, the editor provides access to any process relevant data
that can be used by your own process elements. For instance, you can
easily transfer process data to your legacy system.

The following part shows the implementation of the above editor. As
mentioned earlier Axon Ivy provides the
:public-api:`IIvyScriptEditor </ch/ivyteam/ivy/process/extension/IIvyScriptEditor.html>` that
represents a text field with IvyScript support and smart buttons. Inside
``createEditorPanelContent`` use the method ``createIvyScriptEditor``
from the ``editorEnvironment`` parameter to create an instance of such
an editor. Use the ``loadUiDataFromConfiguration`` method to read the
bean configuration and show within the UI components. Inside this method
you can use the methods ``getBeanConfiguration`` or
``getBeanConfigurationProperty`` to read the bean configuration. Use the
method ``saveUiDataToConfiguration`` to save the data in the UI
components to the bean configuration. Inside this method you can use
methods ``setBeanConfiguration`` or ``setBeanConfigurationProperty`` to
save the bean configuration.

::

   public static class Editor extends AbstractProcessExtensionConfigurationEditor
   {
     private IIvyScriptEditor editorUser;
     private IIvyScriptEditor editorEventTyp;
     private IIvyScriptEditor editorLinkId;
     private IIvyScriptEditor editorFieldValue;

     @Override
     protected void createEditorPanelContent(Container editorPanel,
             IProcessExtensionConfigurationEditorEnvironment editorEnvironment)
     {
       editorPanel.setLayout(new GridLayout(4, 2));
       editorUser = editorEnvironment.createIvyScriptEditor(null, null, "String");
       editorEventTyp = editorEnvironment.createIvyScriptEditor(null, null, "String");
       editorLinkId = editorEnvironment.createIvyScriptEditor(null, null, "String");
       editorFieldValue = editorEnvironment.createIvyScriptEditor(null, null);

       editorPanel.add(new JLabel("User"));
       editorPanel.add(editorUser.getComponent());
       editorPanel.add(new JLabel("Event Typ"));
       editorPanel.add(editorEventTyp.getComponent());
       editorPanel.add(new JLabel("Link-Id"));
       editorPanel.add(editorLinkId.getComponent());
       editorPanel.add(new JLabel("Feldwert"));
       editorPanel.add(editorFieldValue.getComponent());
     }

     @Override
     protected void loadUiDataFromConfiguration()
     {
       editorUser.setText(getBeanConfigurationProperty("User"));
       editorEventTyp.setText(getBeanConfigurationProperty("EventTyp"));
       editorLinkId.setText(getBeanConfigurationProperty("LinkId"));
       editorFieldValue.setText(getBeanConfigurationProperty("Feldwert"));
     }

     @Override
     protected boolean saveUiDataToConfiguration()
     {
       setBeanConfigurationProperty("User", editorUser.getText());
       setBeanConfigurationProperty("EventTyp", editorEventTyp.getText());
       setBeanConfigurationProperty("LinkId", editorLinkId.getText());
       setBeanConfigurationProperty("Feldwert", editorFieldValue.getText());
       return true;
     }
   }

At runtime, you have to evaluate the IvyScript the user has entered into the
IvyScript editors. If you implement for example the class
:public-api:`AbstractUserProcessExtension
</ch/ivyteam/ivy/process/extension/impl/AbstractUserProcessExtension.html>`
there is a perform method that is executed at runtime. At this point, you want to
access the configured data in the editor. The following code snippet shows how
you can evaluate the value of a :public-api:`IIvyScriptEditor
</ch/ivyteam/ivy/process/extension/IIvyScriptEditor.html>`. If you use the
:public-api:`IIvyScriptEditor
</ch/ivyteam/ivy/process/extension/IIvyScriptEditor.html>` you only get the
value by calling the ``executeIvyScript`` method of the
:public-api:`AbstractUserProcessExtension
</ch/ivyteam/ivy/process/extension/impl/AbstractUserProcessExtension.html>`.

::

   public CompositeObject perform(IRequestId requestId, CompositeObject in,
        IIvyScriptContext context) throws Exception
   {
     IIvyScriptContext ownContext;
     CompositeObject out;
     out = in.clone();
     ownContext = createOwnContext(context);

     String eventtyp = "";
     String linkId = "";
     String fieldValue = "";
     String user= "";

     user = (String)executeIvyScript(ownContext, getConfig().get("User"));
     eventtyp = (String)executeIvyScript(ownContext, getConfig().get("Event Typ"));
     linkId = (String)executeIvyScript(ownContext, getConfig().get("Link-Id"));
     fieldValue = (String)executeIvyScript(ownContext, getConfig().get("Feldwert"));
     
     // add your call here
     
     return out;
   }     

