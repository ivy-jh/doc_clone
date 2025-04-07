.. _health:

Health
======

Axon Ivy has multiple health checks that analyze if the Engine
is correctly set up and configured. Additional health checks analyze if the
Engine runs stable and is healthy.

If a health check fails a health message is created with a severity (`LOW`, `HIGH`, or `CRITICAL`)
and a description of the problem and how to fix it. Some health messages also show a link to an
Engine Cockpit view that provides more information about the problem or where you can fix a configuration.      

Engine Cockpit
--------------

Health messages are displayed in the :ref:`engine-cockpit` on:

* The :guilabel:`Health` panel in the :ref:`engine-cockpit-dashboard`
* The :ref:`engine-cockpit-top-menu` 
* The :ref:`engine-cockpit-monitor-health` view

