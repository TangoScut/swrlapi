package org.swrlapi.ui.model;

import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.swrlapi.core.SWRLAPIOWLOntology;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.core.impl.DefaultSWRLAPIRulePrinter;
import org.swrlapi.parser.SWRLParser;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.ui.view.SWRLAPIApplicationView;

public class SWRLAPIApplicationModel implements SWRLAPIModel
{
	private final SWRLRuleEngine ruleEngine;
	private final SQWRLQueryEngine queryEngine;
	private final SWRLParser swrlParser;
	private final DefaultPrefixManager prefixManager;
	private final DefaultSWRLAPIRulePrinter swrlRulePrinter;
	private final SWRLRulesTableModel swrlRulesTableModel;

	private SWRLAPIApplicationView applicationView;

	public SWRLAPIApplicationModel(SWRLAPIOWLOntology swrlapiOWLOntology, SWRLRuleEngine ruleEngine,
			DefaultPrefixManager prefixManager)
	{
		this.ruleEngine = ruleEngine;
		this.queryEngine = ruleEngine;
		this.swrlParser = new SWRLParser(swrlapiOWLOntology, prefixManager);
		this.prefixManager = prefixManager;
		this.swrlRulePrinter = new DefaultSWRLAPIRulePrinter(prefixManager);
		this.swrlRulesTableModel = new SWRLRulesTableModel(ruleEngine, swrlRulePrinter);
	}

	public SWRLAPIApplicationView getApplicationView()
	{
		return this.applicationView;
	}

	public SWRLRuleEngine getSWRLRuleEngine()
	{
		return this.ruleEngine;
	}

	public SQWRLQueryEngine getSQWRLQueryEngine()
	{
		return this.queryEngine;
	}

	public SWRLParser getSWRLParser()
	{
		return this.swrlParser;
	}

	public DefaultPrefixManager getPrefixManager()
	{
		return this.prefixManager;
	}

	public SWRLRulesTableModel getSWRLRulesTableModel()
	{
		return this.swrlRulesTableModel;
	}

	public void setApplicationView(SWRLAPIApplicationView applicationView)
	{
		this.applicationView = applicationView;
	}

	public void saveSWRLRules()
	{
		// TODO
	}

	public boolean areRulesModified()
	{
		return swrlRulesTableModel.hasBeenModified();
	}

	public void clearModifiedStatus()
	{
		swrlRulesTableModel.clearModifiedStatus();
	}
}