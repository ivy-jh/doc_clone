.. _systemdb-mariadb:

MariaDB
-------

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-systemdb-mariadb.yaml
  :language: yaml
  :linenos:

We only support the storage engine **InnoDB**. If database is created by the
Axon Ivy Engine, the character set ``utf8mb4`` is used and the collation is set to
``utf8mb4_unicode_520_ci``.
  
.. tip::
  If you experience bad query performance in Portal, then try to increase the
  setting ``innodb-buffer-pool-size`` in the :file:`my.cnf` configuration 
  file of the database.
