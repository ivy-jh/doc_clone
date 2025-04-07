.. _configuration-security-system:

Workflow Users
==============

Workflow Users are managed in so-called security systems that you can define in
:ref:`ivy-yaml`. The :code:`default` security system is pre-configured on every
|ivy-engine|. For each security system you can define an identity provider. We
distinguish between the following identity providers:

* **Internal Identity Provider**:
  Used to manage its workflow users directly on the |ivy-engine|. Only the
  :code:`Ivy Security System` is an internal identity provider which has no
  further settings and is configured by default. No futher configurations are need
  if you want to go with this.

* **External Identity Provider**:
  Used to synchronize users from an external identity provider such as Active
  Directory. In addition to the users from the identity provider, users can also
  be added and managed manually like in the :code:`Ivy Security System`.

  We support the following identity providers by default:

  - :ref:`keycloak`
  - :ref:`microsoft-entra-id`
  - :ref:`microsoft-ad`
  - :ref:`novell-edirectory`

  The external identity provider provides a unique identity for each user, which
  contains neither the surname nor the first name of the user. This ensures that
  the user is successfully synchronised even if the name changes. If no user
  with the external ID is found in the system database during synchronisation,
  there is a fallback to the external name and then to the actual user name.

  If a user is no longer available via the identity provider, it is
  disabled. All assigned tasks remain in the current status but can be queried
  via the unavailable activator filter using the :public-api:`TaskQuery </ch/ivyteam/ivy/workflow/query/TaskQuery.IFilterableColumns.html#activatorAvailable()>` 
  API or the Portal task list. These tasks can then be reassigned to available users by 
  a workflow administrator.

Read more about the :ref:`lifecycle of an application <application-lifecycle>`
if you are interested how applications and security system works together. 
Having multiple security systems on the same engine is only a use case for
:ref:`multi-tenancy`.
