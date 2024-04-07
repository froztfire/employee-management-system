import axios from "axios";

const EMPLOYEE_REST_API_BASE_URL = "http://localhost:8090/api/employees";

export const listEmployees = () => {
  return axios.get(EMPLOYEE_REST_API_BASE_URL);
};

export const createEmployee = (employee) => {
  return axios.post(EMPLOYEE_REST_API_BASE_URL, employee);
};

export const getEmployee = (employeeId) => {
  return axios.get(EMPLOYEE_REST_API_BASE_URL + "/" + employeeId);
};

export const updateEmployee = (employeeId, employee) => {
  return axios.put(EMPLOYEE_REST_API_BASE_URL + "/" + employeeId, employee);
};

export const deleteEmployee = (employeeId) => {
  return axios.delete(EMPLOYEE_REST_API_BASE_URL + "/" + employeeId);
};
