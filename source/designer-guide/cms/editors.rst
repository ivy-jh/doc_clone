Editors
=======

The content management system can be viewed and edited in the Axon Ivy Designer.

.. _cms-view:

CMS view
~~~~~~~~

The CMS view shows the CMS of all open projects in the workspace including all
content objects and their values.

:guilabel:`Window` > :guilabel:`Show View` > :guilabel:`CMS`

.. figure:: /_images/cms/cms-tree-view.png


Display Content Object Values
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

The view represents the CMS structure as a tree. Furthermore the table can
display one column for every language that is available. In those columns the
value of the corresponding content object in the corresponding language is
shown. You can configure for which languages the table should display a column
by clicking on |imgViewMenu|.

If you want to focus on the CMS structure then you can hide all the language
columns so that only the first column is displayed. Just click on
|imgLanguageChooser| in the toolbar of the view to toggle between hiding and
displaying the columns for the languages.

.. |imgViewMenu| image:: /_images/cms/icon-view-menu.png
.. |imgLanguageChooser| image:: /_images/cms/action-toggle-lang-columns.png


Inline Editing
~~~~~~~~~~~~~~

For text based types you can edit the text directly in the view, just click in
the cell of the value and type.

For file based types you can import a file for each value directly in the cell.
Just move your mouse over the cell of the value click on the |imgImport| icon.
Values for which already content is available show a ``...`` in their cell.

.. |imgImport| image:: /_images/cms/action-import.png


Search
~~~~~~

By using the search you can filter the contents in the view
according to your search string. Enter a filter expression and the 
table tree will be reduced to only show the content object matching that
expression.

.. figure:: /_images/cms/cms-search.png

You can use ``*`` as wildcard character to match any characters.
Furthermore you can use ``?`` to match any single character.



Context Menu
~~~~~~~~~~~~

In the context menu in the CMS view there are several actions available:

:guilabel:`Add...`

  Creates new content objects with the given type, name and value.

  As name you can use a simple name, an absolute or relative path CMS path. All
  necessary will be created automatically.

  The value for text based types can be edited directly in the value column whereas
  for file based type a |imgImport| button is available.

:guilabel:`Add from file(s)...`
  
  Creates new content objects based on the selected files in the file chooser.  
  The filename will be taken as name and the type will be automatically detected.
  
:guilabel:`Add from URL...`

  Creates new content objects from the given URL.

|imgRename| Rename
   Opens a dialog where you can enter a new name for the currently
   selected content object.

   .. warning::

      Renaming a content object will break all references to the object
      or its children.

|imgCopy| Copy
   Copies the currently selected content object including all of its
   children to the clipboard. The copied content objects can be
   inserted somewhere else in the content tree with :guilabel:`Paste`.

|imgPaste| Paste
   Inserts any content object(s) that was copied before to the clipboard
   with :guilabel:`Copy`. The copied content objects are inserted as children of
   the selected content object.

|imgDelete| Delete
   Deletes the currently selected content object including all of its
   children.

   .. warning::

      Deleting a content object will break all references to the object
      or its children.

|imgCopy| Copy URI
   Copies the URI of the currently selected content object to the system
   clipboard. Use :guilabel:`CTRL` + :guilabel:`v` to insert the URI into any text fields or
   editors.

|imgCopyUriMacro| Copy URI as IvyScript macro
   Copies the URI of the currently selected content object as an
   *IvyScript macro tag* to the system clipboard. Use :guilabel:`CTRL` + :guilabel:`v` to
   insert the macro into a :ref:`macro-editor`.

|imgRefresh| Refresh Content
   Reloads the content below the currently selected content object.


Drag and Drop
~~~~~~~~~~~~~

Content objects (e.g., *strings* and *images*) from the CMS view can be
dragged and dropped into the :ref:`HTML Dialog editor <html-dialog-editor-dragndrop>`
to be used for label texts or for images.

.. |imgRename| image:: /_images/cms/action-rename.png
.. |imgCopy| image:: /_images/cms/action-copy.png
.. |imgPaste| image:: /_images/cms/action-paste.png
.. |imgDelete| image:: /_images/cms/action-delete.png
.. |imgCopyUriMacro| image:: /_images/cms/action-copy-uri-as-macro.png
.. |imgRefresh| image:: /_images/cms/action-refresh.png
.. |imgExport| image:: /_images/cms/action-export.png





.. _cms-content-object-editor:

Content Object Editor
~~~~~~~~~~~~~~~~~~~~~

Double-clicking a content object opens the content object Editor to modify
the content object.

The editor has a header with a title and buttons for the most important
actions.

.. figure:: /_images/cms/cov-editor-document.png

|imgAdd| Add new content object value
   Adds a new value to this content object. A dialog is opened for the
   user to select the language of the new value.

|imgRename| Rename content object
   Renames the content object.

|imgCopy| Copy content object
   Copies this content object with all its children to the
   clipboard. The copied objects can be inserted somewhere else in the
   content tree with :guilabel:`Paste`.

|imgDelete| Delete content object
   Deletes this content object with all values and all child content objects.

.. |imgAdd| image:: /_images/cms/action-other-language.png


Each of the values of a content object is shown with its corresponding value
editor inside a collapsible section that is labelled with the *language* of the
value. You find some actions on the right side:

|imgImport| Import value content
   Import content from a file.

|imgExport| Export value content
   Export the content to a file.

|imgCopy| Copy content object value
   Copies this content object value to the clipboard. The copied objects
   can be inserted somewhere else in the content tree with :guilabel:`Paste`.

|imgDelete| Delete content object value
   Deletes this content object value.





.. _cms-content-object-value-editors:

Content Object Value Editors
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

There are different editors for the different content object types.


.. _cms-text-editor:

Text Editor
^^^^^^^^^^^

This editor can handle texts. You can edit them directly in the editor.

.. figure:: /_images/cms/cov-editor-text.png


.. _cms-image-editor:

Image Editor
^^^^^^^^^^^^

This editor can handle images of type GIF, PNG and JPG. You can import and
export images.

.. figure:: /_images/cms/cov-editor-image.png


.. _cms-document-editor:

Document Editor
^^^^^^^^^^^^^^^

This editor can handle all document file types such as TXT, XML, DOC, PDF and
much more. Binary based file types (e.g PDF) you only can import and export
them. Text based file types can be edited directly in the editor.

.. figure:: /_images/cms/cov-editor-document.png
