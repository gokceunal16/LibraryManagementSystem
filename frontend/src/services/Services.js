import axios from 'axios';

const BASE_URL = 'http://localhost:8080'; // Update with your backend URL

const Services = {


    getTableNames:(token)=>{
        return axios.get(`${BASE_URL}/tables`,{
                headers: {
                    Authorization: 'Bearer ' + token
                }
            }
            );
    },

    getTable: (tableName,token) => {
        return axios.get(`${BASE_URL}/${tableName}`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },

    addRecord: (tableName, recordData,token) => {
        return axios.post(`${BASE_URL}/${tableName}`, recordData, {
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },

    updateRecord: (tableName, recordId, newData,token) => {
        return axios.put(`${BASE_URL}/${tableName}/${recordId}`, newData, {
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },


    deleteRecord: (tableName, recordId,token) => {
        return axios.delete(`${BASE_URL}/${tableName}/${recordId}`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },


    getStatistics: (token, name) => {
        return axios.get(`${BASE_URL}/dashboard/${name}`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        })
    },
    getUserHistory: (token,tableName) => {
        return axios.get(`${BASE_URL}/user/${tableName}`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        })

    },

    getBookDetails: (token, publication_id) => {
        return axios.get(`${BASE_URL}/book_detail/${publication_id}`,{
            headers: {
                Authorization: 'Bearer ' + token
            }
        });
    },

};

export default Services;