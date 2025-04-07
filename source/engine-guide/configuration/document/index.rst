.. _document-storage:

Document Storage
================

Documents, such as case documents, need to be stored persistently.
The |ivy-engine| can store such files in different locations depending on the configuration.

The following Document Storages are bundled as part of the Axon Ivy Engine:

.. toctree::
   :maxdepth: 1

   local
   s3

By default, the files are stored in the :ref:`local file system <documents-local>`. The setting can be changed
per security system.

.. literalinclude:: ivy-document-storage.yaml
  :language: yaml
  :linenos:
