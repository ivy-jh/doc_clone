.. _cluster-container:

Container Image
===============

We strongly recommend operating an Axon Ivy Engine Cluster in a containerized 
environment like Docker or Kubernetes.

We recommend that you build your own container image that contains the Axon Ivy Engine 
and includes your projects and configuration.

You can build the container image automatically by using a build server.

.. graphviz:: container.dot
   
The build server:   

#. Checks out:
 
   -  all your projects 
   -  your configurations
   -  a Dockerfile that specifies how to build your container image from a Git
      repository.
#. Builds all your projects and bundles them in an application zip file.
#. Builds your container image as defined by the Dockerfile. 
   It pulls the base image ``axonivy/axonivy-engine`` image from Docker Hub.
#. It stores your new image (``your-company/your-project``) in a `Docker
   Registry <https://hub.docker.com/_/registry>`_.

Then, you can start your Axon Ivy Engine Cluster using your new container image
(``your-company/your-project``).

A simple Dockerfile that bundles the Axon Ivy Engine, your projects, and your
configuration files in a container image looks as follows:

.. code:: dockerfile

  # The base docker image 
  FROM axonivy/axonivy-engine:|version|
  
  # Add your adapted ivy.yaml configuration file 
  ADD --chown=ivy:ivy config/ivy.yaml /ivy/configuration/ivy.yaml
  
  # Add your license file 
  ADD --chown=ivy:ivy config/myCompany.lic /ivy/configuration/myCompany.lic
  
  # Add your projects bundled in an application zip file 
  ADD --chown=ivy:ivy application/target/application.zip /ivy/deploy/application.zip
  
  # Create a data directory to be mounted as a docker volume 
  # to be shared between cluster nodes
  RUN mkdir -p /ivy/data && chown -R ivy /ivy/data

Examples
--------

Please refer to our :link-url:`project-build-examples <build-examples-docker>`.
It shows you how to use Maven to build your container image including both your
Axon Ivy Engine and your application zip file.

Additionally, refer to our example configurations on GitHub for 
:link-url:`NGINX <docker-scaling-nginx>` and :link-url:`HAProxy <docker-scaling-haproxy>` to
learn how to set up an Axon Ivy Engine Cluster with docker-compose.
