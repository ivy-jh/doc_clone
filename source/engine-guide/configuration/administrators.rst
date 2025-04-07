.. _engine-administrators:

Administrators
==============

Administrators can configure, monitor and manage the Axon Ivy Engine.
At least one administrator must be configured in :ref:`ivy-yaml`.


.. literalinclude:: ../../../target/resources/includes/configuration/templates/ivy-administrator.yaml
  :language: yaml
  :linenos:


It is highly recommended to hash passwords of administrators by enclosing the
password in cleartext with :code:`"${hash:` and :code:`}"` like
:code:`"${hash:1234}"` for password :code:`1234`. Hashed passwords
can not be decrypted anymore.
The Axon Ivy Engine will automatically hash and replace the password in file,
when the configuration will be loaded
