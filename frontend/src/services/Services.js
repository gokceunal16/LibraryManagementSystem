import axios from 'axios';
import {useAuth} from "../utils/hooks/useAuth";

const BASE_URL = 'http://localhost:8080'; // Update with your backend URL

const Services = {


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


    getCounts: (token) => {
        return axios.get(`${BASE_URL}/dashboard/counts`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        })
    },

};

export default Services;