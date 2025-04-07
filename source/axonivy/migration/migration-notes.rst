.. _migration-notes:

Migration Notes
---------------

This chapter informs you in detail about incompatibilities that were introduced between
different |ivy| versions and tells you what needs to be done to get your existing projects
working with the newest version. Go through the migration notes from version to version.

.. toctree::
   :maxdepth: 1

   migration-notes-120-131

.. _previous-migi-notes:

.. rubric:: Previous Migration Notes 

:ref:`migration-tools` still support migrating directly from this version:

* :dev-url:`Migrating from 10.0 to 12.0 </doc/12.0/migration-notes>`

Migrating from these versions is no longer supported by the :ref:`migration-tools`: 

* :dev-url:`Migrating from 8.0 to 10.0 </doc/10.0/migration-notes>`
* :dev-url:`Migrating from 7.0 to 8.0 </doc/8.0.0/migration-notes>`
* :dev-url:`Migrating from 6.0 to 7.0 </doc/7.0.0/migration-notes>`
* :dev-url:`Migrating from 5.1 to 6.0 </doc/6.0.0/migration-notes>`
* :dev-url:`Migrating from 5.0 to 5.1 </doc/5.1.0/migration-notes>`
* :dev-url:`Migrating from 4.3 to 5.0 </doc/5.0.5/migration-notes>`

Please migrate first to a newer version that still support your old version and then migrate to the next version. 
E.g., for migrating from 6.0 to 12.0, first install 8.0 and migrate your old |ivy-engine| from 6.0 to 8.0 and then 
install 12.0 and migrate from 8.0 to 12.0.
