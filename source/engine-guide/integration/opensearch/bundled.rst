.. _opensearch-bundled:

Bundled OpenSearch
------------------

The bundled OpenSearch server works out-of-the-box. No further configurations
are usually required. However, you may want to further tune the bundled
OpenSearch server, for which you can go to the OpenSearch configuration folder
:code:`[ivyEngine]/configuration/opensearch`. You can find the logs of the
bundled OpenSearch server by default in :code:`[ivyEngine]/logs/opensearch`.

We have reduced the amount of assigned memory for OpenSearch. These settings can
be changed in :code:`[ivyEngine]/configuration/opensearch/jvm.options`. In
addition, we also have fine-tuned the watermark setting, a self-protection
mechanism for a disk overflow, in
:code:`[ivyEngine]/configuration/opensearch/opensearch.yml`.
