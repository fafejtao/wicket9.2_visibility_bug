package com.mycompany;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;

public class MyPanel extends Panel {

    public MyPanel(String id) {
        super(id);
        setOutputMarkupPlaceholderTag(true);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new Label("label", "Hello world!"));
        add(new AjaxLink<Void>("hideLink") {
            @Override
            public void onClick(AjaxRequestTarget target) {
                MyPanel.this.setVisibilityAllowed(false);
                target.add(MyPanel.this);
            }
        });
    }
}
