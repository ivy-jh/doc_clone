Overriding
==========

You can override content objects of existing projects by defining the same
content object in your dependent project.


**Example**

- Project custom depends on project base (custom -> base)
- Base comes with the content object :code:`/labels/name`
- You can define content object :code:`/labels/name` in project custom and the
  content object values of project custom will be loaded
