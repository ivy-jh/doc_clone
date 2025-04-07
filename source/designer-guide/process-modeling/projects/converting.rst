

.. _project-convert:

Converting Projects
-------------------

Converting Project Version
==========================

If the project format version changes with a new Axon Ivy release, then
old projects will show an error marker, describing them as *out of date*
or having an invalid version. This can happen, when the technical format
for Axon Ivy projects changes with a new Axon Ivy release (e.g., the way
how some artifacts are stored may be changed, new artifacts may be
introduced, etc.). :

.. figure:: /_images/ivy-project/convert-wrong-version.png
   :alt: Wrong project version marker

   Wrong project version marker

If you inspect your project's properties, the main page will show you
the actual project version and inform you whether it is up to date or
not (see :ref:`project-preferences` below):

.. figure:: /_images/ivy-project/convert-project-version-before-conversion.png
   :alt: Project version before conversion

   Project version before conversion

.. figure:: /_images/ivy-project/convert-project-version-after-conversion.png
   :alt: Project version after conversion

   Project version after conversion

Axon Ivy can convert your old projects automatically to the newest
project format for you. During this process, all existing artifacts will
be converted (if necessary) so as to work with the new Axon Ivy version,
and any missing but required artifacts will be added.

.. _project-convert-wizard:
 
Convert Project Wizard
======================

To run the project conversion, either run the quick fix on the error marker
or select the project's node in the Axon Ivy
project view and right click to bring up the context menu. Select
*Convert Project* to open the *Convert Project* wizard. 

.. figure:: /_images/ivy-project/convert-invoking-conversion.png
   :alt: Invoking the project conversion

   Invoking the project conversion

Choose the projects you want to convert and press *Next >*.

.. figure:: /_images/ivy-project/convert-project-1.png
   :alt: Convert Project Wizard - Choose Projects Page
   
   Convert Project Wizard - Choose Converter Page

This wizard provides different converters. 
Choose *Convert project to latest version* and press *Next >*.

.. figure:: /_images/ivy-project/convert-project-2.png
   :alt: Convert Project Wizard - Choose Converter Page
   
   Convert Project Wizard - Choose Converter Page
   
On the next page of the wizard, press the *Convert* button to start the converter.
The executed tasks and actions of the converter are logged into the text area above 
the *Convert* button. That documents the conversion process and will inform you about
whether the conversion was successful or not.


.. figure:: /_images/ivy-project/convert-project-3.png
   :alt: Convert Project Wizard - Convert Page
   
   Convert Project Wizard - Convert Page
   
Once the converter has finished, use the *Copy Log* or *Open Logs* buttons to copy the 
log or open the log files (that are stored in the logs folder of your projects) in editors. 
Press *Next >* to execute the next available converter or if no more converters are available *Finish* to close the wizard. 
You can also press *Cancel* if you want to commit the changes of the last converter. 
Simply start the *Convert Project* wizard again to resume with the next converter.  

.. figure:: /_images/ivy-project/convert-project-4.png
   :alt: Convert Project Wizard - Log
   
   Convert Project Wizard - Log 

.. warning::   

   It is absolutely recommended that you create a copy of your project
   before invoking the conversion. Alternatively you can have your
   project under version control. In this case, make sure that all your
   projects are checked in, before you invoke the conversion, so that
   you can easily roll back (revert) to the old version, if conversion
   should fail for some reason.

More project converters:
========================

For more information about the other project converters, have a look at:

* :dev-url:`Primefaces 13 </doc/12.0/axonivy/migration/migration-notes-112-113.html#primefaces-13>`
* :ref:`Portal Converter <portal-guide>`

In the :ref:`migration-notes` migration tasks, for witch the  
*Convert Project* wizard provides a project converter, are marked with |tag-project-auto-convert|.
