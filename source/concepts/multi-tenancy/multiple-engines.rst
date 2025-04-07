.. _multi-tenancy-engines:

Multiple Engines
----------------

The simplest and safest way to achieve multi-tenancy is to run a separate
|ivy-engine| installation per tenant or per customer. Doing so brings the
following advantages:

- **Security**: A separate installation per customer assures that tenants are
  isolated on the infrastructure level. It is impossible for a customer to see
  data from another customer due to programming errors or misconfigurations.

- **Scaling**: A separate |ivy-engine| per tenant is simple to maintain and
  scales very well. On the other hand, if you run an |ivy| Cluster installation
  and let all customers run on that cluster, you can add more and more nodes to
  the cluster to handle the additional load. However, the cluster solution
  cannot scale infinitely. Because adding more nodes induces more communication
  between the nodes, the network bandwidth available between the cluster nodes
  limits its growth potential. Adding more nodes at that point makes the cluster
  slower.

- **Canary Deployments**: Introducing new features always carries risks. Instead
  of rolling out a new feature to all customers in one fell swoop, you provide
  only a select group of the customers with the new version. If something goes
  wrong, only that group is affected. With a separate |ivy-engine| per tenant,
  Canary Deployments are easy to implement.

- **Stability**: If a customer's |ivy-engine| crashes, only that customer is
  affected. All other customers are not affected by that crash.

These are the main reasons why we advocate multi-tenancy with isolated
|ivy-engine| installations. We recommend using container environments such as
`Docker <https://www.docker.com/>`_, `Kubernetes <https://kubernetes.io/>`_ or
`OpenShift <https://openshift.io/>`_ that have solved the provisioning cleanly
and keep administrative overhead to a minimum.

Get started with our |ivy-engine| Docker container :ref:`here
<getting-started-docker>`.

|

.. graphviz:: multiple-engines.dot
  :align: center

|
