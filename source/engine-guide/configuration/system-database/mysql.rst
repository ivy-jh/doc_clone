.. _systemdb-mysql:

MySQL
-----

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-mysql.yaml
  :language: yaml
  :linenos:

We only support storage engine **InnoDB**. If database will be created by the
Axon Ivy Engine the charset is set to ``utf8mb4`` and collation is set to
``utf8mb4_unicode_520_ci``.

.. tip::
  If you experience bad query performance in Portal, then try to increase the
  setting ``innodb-buffer-pool-size`` in the :file:`my.cnf` configuration 
  file of the database. 
