.. _deployment-rest-api:

REST API
========

The Axon Ivy Engine comes with :api-browser-url:`REST deployment API <system>`
which can be used to deploy new applications or projects. It can be inspected
with the :ref:`integration-rest-api-browser`.

The REST deployment API makes highly customized deployment chains possible. This
is the prefered approach to build a CI/CD pipeline because it is platform
independent. You can use any tool you want to call this REST API like
:code:`curl`. Whether a deployment was succesful or not can be checked by
verifying the http status code, which must be :code:`200`.

Example how to deploy via curl:

.. code:: bash

    sh "curl -X POST http://localhost/system/api/apps/myApp -u admin:admin -H 'X-Requested-By: curl' -F fileToDeploy=@/tmp/app.zip"

Explanation:

* :code:`-X POST`: You need to send a HTTP POST request.
* :code:`http://localhost/system/api/apps/myApp`: URL targeting your
  application.
* :code:`-u admin:admin`: Username and password of an administrator user.
* :code:`-H 'X-Requested-By: curl'`: HTTP Header to prevent CSRF attacks. Any
  value for :code:`curl` possible.
* :code:`-F fileToDeploy=@/tmp/app.zip`: The file which needs to be deployed.

The :code:`deploy.options.yaml` can be provided within the file to deploy or
additionally specified in the HTTP request, read more here:
:api-browser-url:`REST deployment API <system>`.
