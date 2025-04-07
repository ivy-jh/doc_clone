.. _html-dialog-editor:

HTML Dialog Editor
^^^^^^^^^^^^^^^^^^

The HTML Dialog editor allows to implement the view of an HTML Dialog
(i.e., the *JSF view*). You can read and edit the JSF (or XHTML) source 
in a text-based editor. 

|html-editor-image4|

Accessibility
~~~~~~~~~~~~~

|ivy| project tree -> double click on the *View* node of an HTML
Dialog

Content Assist (Ctrl+Space)
~~~~~~~~~~~~~~~~~~~~~~~~~~~

In addition to the auto completion support you get further assistance
for writing expressions if you press ``Ctrl+Space`` on an expression to
get a pop-up with context aware list of proposed code fragments to
select from.

|html-editor-image5|

Quick Fix (Ctrl+1)
~~~~~~~~~~~~~~~~~~

There are Quick Fixes available to create missing events, methods and
data attributes on the current HTML Dialog. Simply press ``Ctrl+1`` on a
**logic** or **data** expression respectively.

|html-editor-image6|

CMS Quick Assist (Ctrl+1)
~~~~~~~~~~~~~~~~~~~~~~~~~

There are Quick Assists available to create or use content objects in
the current HTML Dialog. Simply press ``Ctrl+1`` on a text attribute or
on text between xml tags.

|html-editor-image7|

.. tip::

   If a new content object is created with the Quick Assist you can
   directly rename the created content object in the HTML Dialog Editor.
   Just type a new name and confirm with ``Enter``, to abort the
   renaming press ``Esc``.


.. _html-dialog-editor-dragndrop:

CMS Drag & Drop support
~~~~~~~~~~~~~~~~~~~~~~~

CMS contents can directly be dragged from the CMS View into the HTML
Dialog Editor. The dropped content will be automatically converted into
a valid JSF tag or EL-expression. Currently the content types String and
Text as well as all Images-types support drag & drop operations.

|html-editor-image8|

Linking to CMS content (F3 or Ctrl)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

There is a shortcut to navigate to CMS content. Simply press ``F3`` on a
**ivy.cms.co(...)** expression to jump to the corresponding object in
the CMS. Alternatively press ``Ctrl`` and click on the link.

Linking to Data Class (F3 or Ctrl)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

There is a shortcut to navigate to a data class definition. Simply press
``F3`` on a **data.xyz** expression to jump to the corresponding Data
Class. Alternatively press ``Ctrl`` and click on the link.

Linking to Logic (F3 or Ctrl)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

There is a shortcut to navigate to a logic element definition. Simply
press ``F3`` on a **logic.xyz** expression to jump to the corresponding
logic element. Alternatively press ``Ctrl`` and click on the link.

Properties View
~~~~~~~~~~~~~~~

Together with the HTML Dialog Editor you will want to use the Eclipse
properties view to define attributes for the UI elements of your dialog.
Simply switch to the **Process Development Perspective** that will
display the properties view at the bottom left area of the workbench
window.

.. |html-editor-image4| image:: /_images/html-dialog-editor/x-html-editor-source.png
.. |html-editor-image5| image:: /_images/html-dialog-editor/html-dialog-editor-contentassist.png
.. |html-editor-image6| image:: /_images/html-dialog-editor/html-dialog-editor-quickfix.png
.. |html-editor-image7| image:: /_images/html-dialog-editor/html-dialog-editor-quickassist.png
.. |html-editor-image8| image:: /_images/html-dialog-editor/x-html-editor-cms-dnd.png
