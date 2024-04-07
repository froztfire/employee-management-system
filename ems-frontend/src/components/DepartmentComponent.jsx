/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */
import React, { useEffect, useState } from "react";
import {
  createDepartment,
  getDepartment,
  updateDepartment,
} from "../services/DepartmentService";
import { useNavigate, useParams } from "react-router-dom";

const DepartmentComponent = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");
  const department = { departmentName, departmentDescription };

  const navigator = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    if (id) {
      getDepartment(id)
        .then((response) => {
          setDepartmentName(response.data.departmentName);
          setDepartmentDescription(response.data.departmentDescription);
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }, [id]);

  function handleDepartmentName(e) {
    setDepartmentName(e.target.value);
  }
  function handleDepartmentDescription(e) {
    setDepartmentDescription(e.target.value);
  }

  function saveOrUpdateDepartment(e) {
    e.preventDefault();
    console.log(department);

    if (id) {
      updateDepartment(id, department).then((response) => {
        console.log(response.data);
        navigator("/departments");
      });
    } else {
      createDepartment(department)
        .then((response) => {
          console.log(response.data);
          navigator("/departments");
        })
        .catch((error) => {
          console.error(error);
        });
    }
  }

  function pageTitle() {
    if (id) {
      return <h2 className="text-center">Update Department</h2>;
    } else {
      return <h2 className="text-center">Add Department</h2>;
    }
  }

  return (
    <div className="container">
      <br /> <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          {pageTitle()}
          <div className="card-body"></div>
          <form>
            <div className="form-group mb-2">
              <label className="form-label">Department Name:</label>
              <input
                type="text"
                placeholder="Enter Department Name"
                name="departmentName"
                value={departmentName}
                className="form-control"
                onChange={handleDepartmentName}
              ></input>
            </div>
            <div className="form-group mb-2">
              <label className="form-label">Department Description:</label>
              <input
                type="text"
                placeholder="Enter Department Description"
                name="departmentDescription"
                value={departmentDescription}
                className="form-control"
                onChange={handleDepartmentDescription}
              ></input>
            </div>
            <button
              className="btn btn-success mb-3"
              onClick={saveOrUpdateDepartment}
            >
              Submit
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default DepartmentComponent;
