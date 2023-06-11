import React, {useCallback, useEffect, useMemo, useState} from 'react';
import MaterialReactTable from 'material-react-table';
import {
    Box,
    Button,
    IconButton,
    Tooltip,
} from '@mui/material';
import {Delete, Edit} from '@mui/icons-material';
import Services from "../services/Services";
import CreateNewRecord from "./CreateNewRecord";

const Table = (props) => {
    const [createModalOpen, setCreateModalOpen] = useState(false);
    const [tableData, setTableData] = useState(props.tableData);
    const [validationErrors, setValidationErrors] = useState({});


    console.log("içerideyim!!!: ", props.tableData)
    useEffect(() => {
        setTableData(props.tableData);
    }, [props.tableData])

    const handleCreateNewRow = (values) => {
        console.log("author", values);
        Services.addRecord(props.tableName.slice(0, -1), values).then(() => {
            props.handleUpdate()
        });
    };

    const handleSaveRowEdits = async ({exitEditingMode, row, values}) => {
        if (!Object.keys(validationErrors).length) {
            tableData[row.index] = values;
            //send/receive api updates here, then refetch or update local table data for re-render
            Services.updateRecord(props.tableName.slice(0, -1), row.getValue('id'), values).then(() => {
                props.handleUpdate()
            })
            exitEditingMode(); //required to exit editing mode and close modal
        }
    };

    const handleCancelRowEdits = () => {
        setValidationErrors({});
    };

    const handleDeleteRow = useCallback(
        (row) => {
            if (
                /* eslint-disable no-restricted-globals */
                !confirm(`Are you sure you want to delete record with id ${row.getValue('id')}`)
            ) {
                return;
            }
            Services.deleteRecord(props.tableName.slice(0, -1), row.getValue('id')).then(() => {
                props.handleUpdate()
            })

        },
        [tableData],
    );

    const getCommonEditTextFieldProps = useCallback(
        (cell) => {
            return {
                error: !!validationErrors[cell.id],
                helperText: validationErrors[cell.id],
                onBlur: (event) => {

                    //remove validation error for cell if valid
                    delete validationErrors[cell.id];
                    setValidationErrors({
                        ...validationErrors,
                    });
                }
            }
        },
        [validationErrors],
    );


    const columns = useMemo(() => {
        if (!tableData || tableData.length === 0) {
            return [];
        }
        // Get the field names from the first data item
        const fieldNames = Object.keys(tableData[0]);
        // Create columns based on field names
        const generatedColumns = fieldNames.map((fieldName) => (
                {
                    accessorKey: fieldName,
                    header: fieldName,
                    size: 140,
                    muiTableBodyCellEditTextFieldProps: ({cell}) => ({
                            ...getCommonEditTextFieldProps(cell),
                        }
                    ),
                }
            )
        )
        return generatedColumns;
    }, [getCommonEditTextFieldProps])


    return (
        <div>
            <div style={{ display: 'flex', marginBottom:'1rem'}}> Record Count: {tableData.length}</div>

            <MaterialReactTable
                displayColumnDefOptions={{
                    'mrt-row-actions': {
                        muiTableHeadCellProps: {
                            align: 'center',
                        },
                        size: 120,
                    },
                }}
                columns={columns}
                data={tableData}
                editingMode="modal" //default
                enableColumnOrdering
                enableEditing
                onEditingRowSave={handleSaveRowEdits}
                onEditingRowCancel={handleCancelRowEdits}
                renderRowActions={({row, table}) => (
                    <Box sx={{display: 'flex', gap: '1rem'}}>
                        <Tooltip arrow placement="left" title="Edit">
                            <IconButton onClick={() => table.setEditingRow(row)}>
                                <Edit/>
                            </IconButton>
                        </Tooltip>
                        <Tooltip arrow placement="right" title="Delete">
                            <IconButton color="error" onClick={() => handleDeleteRow(row)}>
                                <Delete/>
                            </IconButton>
                        </Tooltip>
                    </Box>
                )}
                renderTopToolbarCustomActions={() => (
                    <Button
                        color="secondary"
                        onClick={() => setCreateModalOpen(true)}
                        variant="contained"
                    >
                        Create New Record
                    </Button>
                )}
            />
            <CreateNewRecord
                columns={columns.slice(1)}
                open={createModalOpen}
                onClose={() => setCreateModalOpen(false)}
                onSubmit={handleCreateNewRow}
            />
        </div>
    );
};


export default Table;
