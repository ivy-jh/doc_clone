.. _migration-upgrade-engine-hotfix:


Hotfix Upgrade
---------------

It's important to keep your productive |ivy-engine| stable and up to date.
Otherwise, you risk to be vulnerable to known **security leaks** and users may
face inconveniences due to known and addressed **bug fixes**. In addition,
**performance issues** may be solved and make using the |ivy-engine| more fun on
a daily basis.

This chapter focuses on hotfix migration in the same release train (e.g., from
``12.0.0`` to ``12.0.2``). If you want to jump from a major version to another
(e.g., from ``10.0`` to ``12.0``) or minor version to another (e.g., from
``11.1`` to ``11.2``) please consult the :ref:`migration-upgrade-engine-major`
chapter.

The way to migrate to the latest hotfix highly depends on the hosting
environment, so please jump right to the execution environment you are using:

.. toctree::
   :maxdepth: 2

   docker
   windows
   linux


Migration comparison:

+----------+---------+------------+---------+
|          | Windows | Any Linux  | Docker  |
+----------+---------+------------+---------+
| Effort   | Medium  | Medium     | Minimal |
+----------+---------+------------+---------+
