import request from '@/utils/request'

// 查询日志测试列表
export function listTestLog(query) {
  return request({
    url: '/test/testLog/list',
    method: 'get',
    params: query
  })
}

// 查询日志测试详细
export function getTestLog(id) {
  return request({
    url: '/test/testLog/' + id,
    method: 'get'
  })
}

// 新增日志测试
export function addTestLog(data) {
  return request({
    url: '/test/testLog',
    method: 'post',
    data: data
  })
}

// 修改日志测试
export function updateTestLog(data) {
  return request({
    url: '/test/testLog',
    method: 'put',
    data: data
  })
}

// 删除日志测试
export function delTestLog(id) {
  return request({
    url: '/test/testLog/' + id,
    method: 'delete'
  })
}
