.. _documents-local:

Local Document Storage
-----------------------

The local document storage stores the files in the local file system. The root path will be calculated out of `Data.Directory` from :ref:`ivy-yaml`.

**Template**

.. literalinclude:: ../../../../target/resources/includes/storage/local/local-blob-storage-template.yaml
  :language: yaml
  :linenos:

**Reference**

.. literalinclude:: ../../../../target/resources/includes/storage/local/local-blob-storage-reference.yaml
  :language: yaml
  :linenos:

.. note::
   Working with local files only works with :ref:`cluster` if you share the same
   root directory for all cluster nodes. In the case of a cluster, you should go with :ref:`documents-s3`.
