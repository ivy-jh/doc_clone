.. _cms-display-content:

Display Content
---------------

You can use content from CMS wherever you want in your business processes. 
In most Axon Ivy Script editors there is a CMS browser available, which generates the correct code for you. 
To access the CMS you can use the variable :public-api:`ivy.cms
</ch/ivyteam/ivy/cm/IContentManagementSystem.html>`.


Content
^^^^^^^

You can load the content with :code:`ivy.cm.co` and use it for example as a
label in your user dialog or as text in your mail. The language-specific value
is loaded according to the :ref:`content resolution principle
<cms-content-resolution>`.

**Example** :code:`ivy.cm.co("/labels/birthday")`

If you want to load the content of a specific locale or you want to replace
templates then you can use the advanced API:

.. code:: java

  ivy.cm.content("/labels/birthday")
    .locale("en")
    .replace("amount", "4")
    .get();

Link
^^^^

You usually want to embed content like images or documents as a link. For this
you can use :code:`ivy.cm.ref`.

**Example** :code:`ivy.cm.ref("/documents/instruction")`

The generated link then looks as follows:
  
  ``/<appName>/cm/<processModelAndVersion>/<cmsPath>.<extension>?l=<locale>&v=<version>``

  e.g.

  ``/designer/cm/cms$1/documents/instruction.pdf?l=en&v=1641303359499``

If you want to generate a link with a specific locale then you can
use then you can use the advanced API:

.. code:: java

  ivy.cm.reference(/documents/instruction")
    .locale("de")
    .get();
