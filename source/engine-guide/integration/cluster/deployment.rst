.. _cluster-deployment:

Deployment
==========

Deployments during runtime are not supported by the Axon Ivy Engine Cluster and do
not work. Use the :ref:`deployment directory <deployment-deploying>` instead
to deploy your projects during Axon Ivy Engine Cluster node startup.

.. note::
   Only during the startup of the master cluster node, information 
   from Axon Ivy projects is deployed to the system database. 
   On startup of slave cluster nodes, projects files are copied to the 
   correct location **without** updating the system database.
   E.g., new roles that have been added to an Axon Ivy project are created in the 
   system database only upon startup of the master cluster node.    

We recommend that you add your projects directly into the deployment directory
``deploy`` of a :ref:`container image <cluster-container>`.  
