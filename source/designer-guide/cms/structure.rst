Structure
=========

The content management system is hierarchical and consists of **content objects**.
Each content object has a type. We distinguish the three types folders, texts
and files.

- **Folders** are used to represent the hierarchical structure.
- **Texts** are needed to store multilingual texts in the :file:`cms_*.yaml`.
- **Files** represents images and documents stored directly in the CMS folder.

A content object can be uniquely addressed via a path (e.g.
:code:`/test/label`), which in turn represents the hierarchical structure.
Content objects (except folders) have **content object values**, where each
value is bound to a locale.

A locale defines the language and optionally the region. This allows you to
define values for different langauges and even for different regions. You can
define a value for English :code:`en` or be more specific for US-English with
:code:`en_US` or British-English with :code:`en_GB`.



**Example**

In this content management system you can see eight content objects. Where
:code:`/`, :code:`/documents`, :code:`/images` and :code:`/labels`` are folders and serve
only for hierarchical presentation. The content objects with real values are:

- :code:`/documents/instruction` is a PDF file content object
  with two content object values for the languages English and German.
- :code:`/images/doc` is a PNG file content object with only
  one content object value and no language assignment.
- :code:`/labels/birthday` and :code:`/labels/name` are
  texts with translations for English and German.

.. figure:: /_images/cms/cms-example.png
   :align: center
   :alt: CMS example

   CMS example

The CMS shown above is mapped transparently on the file system. The files are
stored in the appropriate locations and the texts all in the :file:`cms_*.yaml`
files. The locale information is appended to the end of the file.

.. figure:: /_images/cms/cms-filesystem.png
   :align: center
   :alt: CMS filesystem structure

   CMS filesystem structure
