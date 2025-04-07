Ivy Archives
-------------

There are two different types of Axon Ivy projects available. Normal
Axon Ivy projects are used to develop artifacts. Artifacts in those
projects are changed frequently. Once the artifacts of a project are
developed and stable you can export the normal Axon Ivy project to an
Axon Ivy Archive. Archives are pre-built Axon Ivy projects that are stored in
one single ``*.iar`` file.

You can import Axon Ivy Archives to a workspace like normal Axon Ivy projects.
All artifacts of an Ivy Archive can be viewed but not edited. Archives
contain all built artifacts. Therefore, they do not have to be
built or validated again in the workspace. As a consequence, Axon Ivy Archives
will improve your workspace build, refresh, and update times.

There are multiple ways to create or import Axon Ivy Archives:

-  Axon Ivy Archives can be :ref:`exported <designer-export-project>`
   and :ref:`imported <designer-import-project>`.

-  Axon Ivy Projects can be packed (archived) or unpacked (unarchived)
   inside the workspace.
   
   .. figure:: /_images/ivy-project/ivy-archive-pack.png
   
   .. figure:: /_images/ivy-project/ivy-archive-unpack.png

.. tip::

   Axon Ivy Archives are not validated automatically. You can start the
   validation manually by using the context menu.

