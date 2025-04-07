Business Data Usage
-------------------

The Business Data feature methods like ``get``, ``save``, ``find`` and
``delete`` are accessible under ``ivy.repo`` in IvyScript.


Associate data with the business case (BusinessCaseData context)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Annotate the main data class of the business case with
``@BusinessCaseData``:

::

   @BusinessCaseData
   public class BusinessCaseDossier
   {
   ...

Get (load or create), modify, and save a business data value in the context of
the current business case:

::

   BusinessCaseDossier dossier = ivy.repo.get(BusinessCaseDossier.class);
   dossier.getPerson().setLastName("Polo");
   ivy.repo.save(dossier);

.. note::
   The method ``get`` works as follows: If a BusinessData object is already 
   associated with the current business case, this object is loaded. If not, 
   a new BusinessData object is created instead.

.. warning::
  :ref:`business-case-data` can only be applied if the case is persistent (i.e.,
  has at least one task)
  

Store (without BusinessCaseData context)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Create and save:

::

   Dossier dossier = ...
   out.businessDataId = ivy.repo.save(dossier).getId();

..

.. tip::

   It is recommended to only store the id of the business value in the process
   data. After a task switch, you must load the business data value from the
   repo with the stored id, because the business data repo does not keep the
   reference to the instance on the task switch.

Load (without BusinessCaseData context)
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Load, modify, and save:

::

   Dossier storedDossier = ivy.repo.find(in.businessDataId, Dossier.class);
   storedDossier.getPerson().setLastName("Polo");
   ivy.repo.save(storedDossier);

Search
~~~~~~

The search capabilities of the Business Data Store are based on
`OpenSearch <https://opensearch.org/>`__ and
therefore fast and powerful.

There is a fluent API to search stored business data. The API supports
filtering, ordering, and limiting of the results:

::

   List<Dossier> result = ivy.repo.search(Dossier.class)
          .allFields().containsAnyWords("Polo Columbus")
          .execute()
          .getAll();

Also `fuzzy
search <https://opensearch.org/docs/latest/query-dsl/term/fuzzy/>`__
and search engine like `query
strings <https://opensearch.org/docs/latest/query-dsl/full-text/simple-query-string/>`__
are supported:

::

   List<Dossier> result = repo.search(Dossier.class)
          .score()
          .allTextFields()
          .query("Baldwin~1 -Alec")
          .execute()
          .getAll();

..

.. warning::

   By default, the search result is limited to 10 entries. Use the method
   ``limit`` if you want to get more results.

Store with own Id
~~~~~~~~~~~~~~~~~

Create and save with own Id:

::

   Dossier dossier = ...
   String yourId = ... // generate your own id, be sure it is unique!
   dosser.id = yourId; // set your id to the Business Data value
   ivy.repo.save(dossier);

   ivy.repo.find(yourId, Dossier.class) // get your Business Data value 

..

.. warning::

   Be aware that the id cannot be changed later. The maximum length of the
   identifier is 100 characters.

Samples
~~~~~~~

The :ref:`WorkflowDemos sample project <importing-demo-projects>`
of the |ivy-designer| contains examples of the Business Data Store usage.

Refer to the Public API ``BusinessDataRepository`` for more code samples.
