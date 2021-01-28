## Project demonstrate BUG in wicket 9.2.0

https://issues.apache.org/jira/browse/WICKET-6863

Method `Component.setVisibilityAllowed` should call `onVisibleStateChanged()`
as method `Component.setVisible` does.

Else exception is thrown:
```
org.apache.wicket.WicketRuntimeException: The component(s) below failed to render. Possible reasons could be that:
	1) you have added a component in code but forgot to reference it in the markup (thus the component will never be rendered),
	2) if your components were added in a parent container then make sure the markup for the child container includes them in <wicket:extend>.
```

Step to reproduce:
- run test com.mycompany.TestHomePage.homepageRendersSuccessfully
- If you change wicket version to 9.1.0. Test will pass.

Problem is in this method
org.apache.wicket.Component.isVisibleInHierarchy at line 2112
where `determineVisibility() != getRequestFlag(RFLAG_VISIBLE_IN_HIERARCHY_VALUE)`
