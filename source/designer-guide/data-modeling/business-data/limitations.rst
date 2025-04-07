Business Data Limitations
-------------------------

Size
   The Business Data store is not designed to store huge binary
   objects like PDFs.

Persistence
   :ref:`business-case-data` can only be applied if the case is persistent (i.e.,
   it has at least one task).

Types
   The |ivy| scripting types ``XML``, and ``Tree`` are not serializable.

   You can store Collection types like an ``ArrayList`` in a field, but
   not as the root object. Always use a simple DataClass or plain old Java
   objects as the root object to store and load in the repository.

   Public API objects like ``IUser``, ``ITask`` should not be stored into the
   Business Data repository. Store the **Id** of a User or Task instead, and reload
   the object using this Id.

   Do not change the type of a stored field (e.g., from ``Number`` to
   ``String``)! The serialization of data you stored previously will fail, and
   |ivy| cannot find Business Data with the new type via the search API as the
   search index is `strongly typed
   <https://opensearch.org/docs/latest/field-types/>`__.

Project Dependencies
   When using the same Business Data value type in the projects 'a'
   and 'b', it is best to define the data classes for the business data
   in a separate project 'base'. Then define a dependency from projects 'a'
   and 'b' to project 'base'.

   .. warning::

      If you use an object of a type defined in project 'a' inside the business
      data value (e.g., add it to a list), then the business data value cannot
      be loaded in project 'b'. This is because project 'b' is not depending on
      project 'a' and therefore cannot load objects of classes that are defined
      in project 'a'.

OpenSearch
   The business data is duplicated into OpenSearch. This offers powerful
   search capabilities. However, there are limitations to be dealt with.

   Do not use a ``Map`` with random or generated keys in your data
   structure, as this forces the creation of an OpenSearch mapping for every data item.

   Prevent cyclic references and back references from lists to the
   parent object, as this can lead to huge json structures while expanding these data
   structures.
