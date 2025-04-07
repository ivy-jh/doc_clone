HTML Dialog Themes
------------------

With themes, the visual appearance of the application such as the color scheme
and the decoration of components can be adapted. PrimeFaces comes with a number
of predefined themes that you can choose from. 

You can also create your own theme. To learn more about PrimeFaces themes, the
web site `PrimeFaces Themes
<https://www.primefaces.org/showcase/theming.xhtml>`__ is the right starting
point.

The theme called **freya-ivy-light** is configured as the default. New dialogs
will be created with this theme if you choose a current layout (template) from
the core. However, you can easily configure another default theme with the
following steps:

-  The `PrimeFaces Built-In Themes
   <https://primefaces.github.io/primefaces/11_0_0/#/core/themes?id=built-in-themes>`__
   are already included in the product. In addition, the
   core offers a :ref:`freya-ivy <freya-themes>` theme. To use your own theme, copy your
   themeXY.jar file into the folder **/webapps/ivy/WEB-INF/lib** of Designer and
   Engine respectively.

-  The parameter ``primefaces.THEME`` can be set as a head
   attribute in your **template.xhtml** file.

   ::

      <h:head>
          ...
          <f:attribute name="primefaces.THEME" value="freya-ivy-light"/>
          ...
      </h:head>

.. _freya-themes:

Freya Themes
^^^^^^^^^^^^

If you choose a **freya** theme, you also need to import an additional layout
stylesheet and script file. 

You can fix the theme to a specific mode :code:`light` or :code:`dark`:

::

  <h:head>
    <f:attribute name="primefaces.THEME" value="freya-ivy-light" />
    <h:outputStylesheet name="css/layout-ivy-light.css" library="freya-layout" />
    <h:outputScript name="js/layout.js" library="freya-layout" />
    ...
  </h:head>

You also have the option to load the mode dynamically and switch it at runtime.
You can do so by setting the cookie :code:`primefaces-theme-mode` to **light** or
**dark**, or call a specific function on the :public-api:`IvyFreyaTheme
</ch/ivyteam/ivy/jsf/primefaces/theme/IvyFreyaTheme.html>`:

::

  <h:head>
    <f:attribute name="primefaces.THEME" value="#{ivyFreyaTheme.theme}" />
    <h:outputStylesheet name="#{ivyFreyaTheme.layout}" library="#{ivyFreyaTheme.library}" />
    <h:outputScript name="js/layout.js" library="#{ivyFreyaTheme.library}" />
    ...
  </h:head>

.. warning::
  If you change an existing template to the **freya-ivy** theme, you may need to set 
  the :code:`body-hd` and the theme mode :code:`#{ivyFreyaTheme.mode}` class on the :code:`<h:body>` tag, 
  or simply start from a new generated frame template:

  :: 

    <h:body class="body-hd #{ivyFreyaTheme.mode}">


.. _primeflex:

PrimeFlex
^^^^^^^^^

PrimeFaces has an additional library `PrimeFlex
<https://www.primefaces.org/showcase/primeflex/setup.xhtml>`__, which allows to
use `FlexBox
<https://developer.mozilla.org/en-US/docs/Learn/CSS/CSS_layout/Flexbox>`__ with
PrimeFaces widgets (e.g., by using :code:`<p:panelGrid layout="flex">`).
Additionally, we recommend to reference :file:`primeflex-3.min.css` in your
template. 

PrimeFlex is provided by the core in version 3 and is by default referenced
in new layouts (templates). You can also add it to your template as follows:

::

  <h:head>
    ...
    <h:outputStylesheet name="primeflex-3.min.css" library="primeflex" />
    ...
  </h:head>


Color Customizing
^^^^^^^^^^^^^^^^^

If you want to change the colors of the :ref:`freya-ivy <freya-themes>`
theme, please have a look at the :ref:`branding` chapter.
