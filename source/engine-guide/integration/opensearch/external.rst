.. _opensearch-external:

External OpenSearch
-------------------

For systems with high load or when running |ivy| in a :ref:`cluster <cluster>`,
you may need to run an external OpenSearch instance. To do so, download and
install OpenSearch according to the docs of `OpenSearch
<https://opensearch.org>`__. 

We only support one version of OpenSearch which is defined in :ref:`system
requirements <engine-system-requirements>`.

To integrate the |ivy-engine| with an external OpenSearch instance you need
configure the :ref:`ivy-yaml`.

.. literalinclude:: ../../../../target/resources/includes/configuration/templates/ivy-external-opensearch.yaml
  :language: yaml
  :linenos:
