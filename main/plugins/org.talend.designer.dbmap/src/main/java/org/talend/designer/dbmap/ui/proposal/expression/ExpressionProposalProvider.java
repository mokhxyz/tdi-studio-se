// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.designer.dbmap.ui.proposal.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.talend.designer.abstractmap.model.table.IDataMapTable;
import org.talend.designer.abstractmap.model.tableentry.IColumnEntry;
import org.talend.designer.abstractmap.model.tableentry.ITableEntry;
import org.talend.designer.dbmap.language.IDbLanguage;
import org.talend.designer.dbmap.managers.MapperManager;
import org.talend.designer.dbmap.model.tableentry.TableEntryLocation;
import org.talend.designer.dbmap.ui.visualmap.zone.Zone;

/**
 * ContentProposalProvider which initialize valid locations of Mapper. <br/>
 * 
 * $Id: ExpressionProposalProvider.java 968 2006-12-12 10:59:26Z amaumont $
 * 
 */
public class ExpressionProposalProvider implements IContentProposalProvider {

    private MapperManager mapperManager;

    private List<IDataMapTable> tables;

    private IDbLanguage currentLanguage;

    private IContentProposalProvider[] otherContentProposalProviders;

    private ITableEntry currentModifiedEntry;

    /**
     * Constructs a new ProcessProposalProvider.
     * 
     * @param tables
     * @param control
     */
    public ExpressionProposalProvider(MapperManager mapperManager,
            IContentProposalProvider[] otherContentProposalProviders) {
        super();
        this.mapperManager = mapperManager;
        this.currentLanguage = mapperManager.getCurrentLanguage();
        this.otherContentProposalProviders = otherContentProposalProviders;
    }

    public void init(IDataMapTable currentTable, Zone[] zones, ITableEntry currentEntry) {

        tables = new ArrayList<IDataMapTable>();
        for (int i = 0; i < zones.length; i++) {
            if (zones[i] == Zone.INPUTS) {
                tables.addAll(mapperManager.getInputTables());
            } else if (zones[i] == Zone.OUTPUTS) {
                tables.addAll(mapperManager.getOutputTables());
            }
        }
        this.currentModifiedEntry = currentEntry;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.fieldassist.IContentProposalProvider#getProposals(java.lang.String, int)
     */
    public IContentProposal[] getProposals(String contents, int position) {
        List<IContentProposal> proposals = new ArrayList<IContentProposal>();

        TableEntryLocation sourceEntryLocation = new TableEntryLocation();

        // Proposals based on process context
        for (IDataMapTable table : this.tables) {
            // proposals.add(new TableContentProposal(table, this.currentLanguage));
            List<IColumnEntry> dataMapTableEntries = table.getColumnEntries();
            for (IColumnEntry entrySource : dataMapTableEntries) {

                sourceEntryLocation.tableName = entrySource.getParentName();
                sourceEntryLocation.columnName = entrySource.getName();
                if (mapperManager.getUiManager().checkSourceLocationIsValid(entrySource, currentModifiedEntry)) {
                    proposals.add(new EntryContentProposal(entrySource, this.currentLanguage));
                }
            }
        }

        for (IContentProposalProvider contentProposalProvider : otherContentProposalProviders) {
            proposals.addAll(Arrays.asList(contentProposalProvider.getProposals(contents, position)));
        }
        IContentProposal[] res = new IContentProposal[proposals.size()];
        res = proposals.toArray(res);
        return res;
    }

}
