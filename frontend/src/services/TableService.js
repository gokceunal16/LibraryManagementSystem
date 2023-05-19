import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Update with your backend URL

const TableService = {

    getTableNames:()=>{
        return axios.get(`${BASE_URL}/tables`);
    },

    getTable: (tableName) => {
        return axios.get(`${BASE_URL}/${tableName}`);
    },

    addRecord: (tableName, recordData) => {
        return axios.post(`${BASE_URL}/${tableName}`, recordData);
    },

    updateRecord: (tableName, recordId, newData) => {
        return axios.put(`${BASE_URL}/${tableName}/${recordId}`, newData);
    },

    deleteRecord: (tableName, recordId) => {
        return axios.delete(`${BASE_URL}/${tableName}/${recordId}`);
    },

};

export default TableService;