.. _engine-cockpit:

Engine Cockpit
==============

The **Engine Cockpit** is the application to administer your engine.


.. rubric:: Opening the Cockpit

After successfully starting the Axon Ivy Engine, you can launch the engine cockpit 
via the Axon Ivy Engine info page. 
To do so, open the address: http://ServerName:Port/ in your browser and click the
:guilabel:`Cockpit` tab. This will open the dashboard: 
http://ServerName:Port/system/engine-cockpit

.. note::
    To use this Engine Cockpit you need an administrator user account. 
    If you run in :ref:`demo-mode`, the administrator user and password are
    **admin**.


.. _engine-cockpit-dashboard:

.. rubric:: Dashboard

The **dashboard** provides a quick overview of your running engine. It displays 
real time information about open sessions, user count, working tasks and
deployed applications. In addition, it shows information about the host 
the engine is running on.

In the :guilabel:`Health` panel, you see if the engine is healthy. 
A description of the problem is displayed if it is not healthy. 

In the :guilabel:`License` panel you have a quick overview of your license. In
the :ref:`engine-cockpit-license` view you have more information and the ability
to upload a new license.

If you have configured an EMail server you can test it by clicking on the
:guilabel:`Send` button in the :guilabel:`Email` panel. This will send a test Email.

.. figure:: /_images/engine-cockpit/engine-cockpit-dashboard.png

.. _engine-cockpit-top-menu:
.. rubric:: Top Menu

A breadcrumb in the top menu bar on the right side helps you navigate and shows your current location. 
On the left side are different items that provide important and useful information or features like:

* Engine Restart
* License messages
* Cluster warning
* Health messages
* Documentation
* Switch between dark and light mode
* Administrator user menu

Some items may not be available or shown depending on your engine. 
  
.. rubric:: Features

Additional configuration views of the cockpit are accessible via menu drawer.

.. toctree::
   :maxdepth: 1

   applications
   security
   configuration
   services
   system
   monitor

