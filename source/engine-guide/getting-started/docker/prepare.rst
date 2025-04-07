Prepare the Docker Image
------------------------

Download and install **docker** and **docker-compose** from https://www.docker.com/.

To test your docker installation, execute the following command in a terminal:

.. code:: bash

   docker run -p 8080:8080 axonivy/axonivy-engine:|version|

Now you can connect to http://localhost:8080 - no joke. There, your Axon Ivy Engine
is running and awaits your commands.

Now press :guilabel:`Ctrl+C` in the terminal or close the terminal to shutdown
the Axon Ivy Engine.
