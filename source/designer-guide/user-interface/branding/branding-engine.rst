.. _branding-engine:

Engine Branding
---------------

To make the engine branding work with your :ref:`html-dialogs`, be sure they
are supporting the :ref:`branding-user-interface` or are based on the latest
:ref:`default templates <html-dialog-layouts>`.


Engine Cockpit Branding View
~~~~~~~~~~~~~~~~~~~~~~~~~~~~

If you want to have an overview of your current branding resources or you want
to change them at runtime, please have a look at the :ref:`Engine Cockpit Branding <engine-cockpit-branding>` view.


.. _branding-configuration:

Configuration
~~~~~~~~~~~~~

Like the :ref:`app-yaml`, you can change Branding resources at runtime in the
:file:`configuration/applications/<APPNAME>/branding` directory. This is also
the directory that is used by the :ref:`Engine Cockpit
<engine-cockpit-branding>`.

::

    configuration
    └── applications
        └── <APPNAME>
            └── branding
                └── custom.css
                └── logo.png
                └── favicon.svg


.. _branding-app-deploy:

Deployment
~~~~~~~~~~

As detailed in the general application :ref:`deployment`, you may deploy
Branding resources within an :ref:`app.zip <deployment-prepare>` in
:file:`config/branding`.

::

    app.zip
    ├── config
    │   └── app.yaml
    │   └── branding
    │       └── custom.css
    │       └── logo.png
    │       └── favicon.svg
    ├── base.iar
    ├── solution.iar
    └── customer.iar


.. _branding-system-default:

Default Branding
~~~~~~~~~~~~~~~~

If your app has no Branding resources :ref:`deployed <branding-app-deploy>` or
:ref:`configured <branding-configuration>`, the default Axon Ivy Branding
resources are used to generate your interfaces. 

If you use multiple applications in a security context, they all share the 
same branding. So it is enough to provide one with branding resources.
